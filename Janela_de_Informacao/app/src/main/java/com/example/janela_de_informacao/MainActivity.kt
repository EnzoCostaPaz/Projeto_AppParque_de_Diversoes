package com.example.janela_de_informacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.janela_de_informacao.ui.theme.Janela_de_InformacaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Janela_de_InformacaoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BumperCarInfoScreen()
                }
            }
        }
    }
}

@Composable
fun BumperCarInfoScreen() {
    Scaffold(
        topBar = { ParkTopAppBar() }
    ) { paddingValues ->
        BumperCarInfo(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun BumperCarInfo(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(dimensionResource(R.dimen.padding_medium))) {
        BumperCarImage(R.drawable.bate_bate)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.padding_medium)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
                Text(
                    text = "O carrinho Bate-Bate é um ótimo entretenimento para crianças de no mínimo 14 anos. Eles podem dirigir os carros e colidir de forma segura uns com os outros em um ambiente controlado.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            ParkButtonSee(
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_small),
                    end = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_medium)
                ))
        }
    }


}

@Composable
fun ParkButtonSee(modifier: Modifier) {
    Button(onClick = { /* TODO: Add action here */ }) {
        Text(text = stringResource(R.string.see_more_button_text))//Este botão Voltara para tela Inicial
    }
}

@Composable
fun BumperCarImage(@DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(RoundedCornerShape(8.dp))
            .size(dimensionResource(id = R.dimen.image_size)),
        contentScale = ContentScale.Crop,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(64.dp) // Tamanho fixo da imagem
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.icon_parque),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ), // Ajuste o estilo do texto
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun BumperCarInfoPreview() {
    Janela_de_InformacaoTheme {
        BumperCarInfoScreen()
    }
}

@Preview
@Composable
fun ParkDarkThemePreview() {
    Janela_de_InformacaoTheme(darkTheme = true) {
        BumperCarInfoScreen()
    }
}

