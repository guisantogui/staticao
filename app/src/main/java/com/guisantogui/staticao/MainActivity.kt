package com.guisantogui.staticao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guisantogui.staticao.data.repository.LeagueRepositoryImpl
import com.guisantogui.staticao.ui.theme.StaticaoTheme
import com.guisantogui.staticao.viewModel.LeagueEvent
import com.guisantogui.staticao.viewModel.LeagueViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repositoryImpl: LeagueRepositoryImpl

    @Inject
    lateinit var leagueViewModel: LeagueViewModel


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StaticaoTheme {

                val state = leagueViewModel.state.collectAsState()

                Scaffold(
                    topBar = {
                        OutlinedTextField(
                            value = state.value.searchTerm,
                            onValueChange = {
                                leagueViewModel.onEvent(LeagueEvent.SetSearchTerm(it))
                            },
                            label = { Text("Pesquisar") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp, bottom = 12.dp, start = 6.dp, end = 6.dp),

                            shape = MaterialTheme.shapes.small,


                            )
                    },
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    floatingActionButton = {
                        IconButton(onClick = {
                            leagueViewModel.onEvent(LeagueEvent.SaveLeague("MINHA LIGA LEGAL"))
                        }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                        }

                    }
                ) { innerPadding ->

                    Column(
                        Modifier.padding(innerPadding)
                    ) {

                        LazyVerticalGrid(
                            contentPadding = PaddingValues(16.dp),
                            columns = GridCells.Fixed(3),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            content = {

                                items(state.value.leagues) {
                                    LeagueItem(it.leagueName, R.drawable.premier_league_uk)
                                }
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun LeagueGrid(modifier: Modifier = Modifier) {

    val list = listOf(
        R.drawable.premier_league_uk,
        R.drawable.bundesliga,
        R.drawable.brasileirao_a,
        R.drawable.la_liga,
        R.drawable.italia_a,
    )

    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        content = {

            items(list) {
                LeagueItem("", it)
            }
        })
}


@Composable
fun LeagueItem(
    league: String,
    logo: Int
) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier.padding(2.dp)

        ) {
            Text(text = league, fontSize = 15.sp)
            Image(
                painter = painterResource(id = logo),
                contentDescription = league,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)


            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun LeagueItemPreview() {
    LeagueItem("Premier League", R.drawable.premier_league_uk)
}


@Preview(showBackground = true)
@Composable
fun LeagueGridComposable() {
    StaticaoTheme {
        LeagueGrid()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {

    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Pesquisar") },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp, start = 6.dp, end = 6.dp),

        shape = MaterialTheme.shapes.small,


        )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    StaticaoTheme {
        SearchBar()
    }
}
