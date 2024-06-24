

package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.Park
import com.example.woof.data.Parks
import com.example.woof.ui.theme.WoofTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ParkApp()
                }
            }
        }
    }
}


@Composable
fun ParkApp() {
    Scaffold(
        topBar = {
            ParkTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(Parks) {
                ParkItem(
                    park = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun ParkItem(

    park: Park,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            ParkIcon(park.imageResourceId)
            ParkInformation(park.name, park.age)
            Spacer(modifier = Modifier.weight(1f))
            ParkItemButton(expanded = expanded,
                            onClick = { expanded = !expanded }

            )
        }

        if (expanded){
            Column(modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
            ) {

            }
            ParkButtonSee(park.hobbies,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_small),
                    end = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_medium)
                )
            )
        }

    }

}

@Composable
private fun ParkItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        IconButton(onClick = onClick) {
            Icon(

                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = stringResource(R.string.expand_button_content_description),
                tint = MaterialTheme.colorScheme.secondary
            )
        }

    }
}

@Composable
fun ParkIcon(
    @DrawableRes parkIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
            painter = painterResource(parkIcon),
            contentDescription = null
    )
}

@Composable
fun ParkInformation(
    @StringRes parkName: Int,
    parkAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(parkName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, parkAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun ParkPreview() {
    WoofTheme(darkTheme = false) {
        ParkApp()
    }
}
@Preview
@Composable
fun ParkDarkThemePreview() {
    WoofTheme(darkTheme = true) {
    ParkApp()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.icon_parque),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}
@Composable
fun ParkButtonSee(hobbies: Int, modifier: Modifier) {
    Button(onClick = { /* TODO: Add action here */ }) {
        Text(text = stringResource(R.string.see_more_button_text))//Este botão levará para segunda tela
    }
}


