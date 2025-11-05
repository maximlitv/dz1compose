package com.example.dz1compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dz1compose.ui.theme.AppDimens
import com.example.dz1compose.ui.theme.Dz1ComposeTheme
import javax.crypto.Cipher

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyScreen()

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun  MyScreen(
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val orientation = configuration.orientation

    val list = rememberSaveable { mutableStateListOf<Int>() }
    var count by rememberSaveable { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(if(orientation ==Configuration.ORIENTATION_PORTRAIT) 3 else 4),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)

        ) {
            items(
                items = list,
            ) { item ->
                Box(
                    modifier = Modifier
                        .padding(AppDimens.SquarePadding)
                        .aspectRatio(1f)
                        .background(
                            color = if (item % 2 == 0)
                                colorResource(R.color.blue)
                            else
                                colorResource(R.color.red)
                        ),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = item.toString(),
                        color = colorResource(R.color.white),
                        fontSize = AppDimens.FontSize
                    )
                }

            }


        }


        FloatingActionButton(
            onClick = {
                count++
                list.add(count)
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(AppDimens.FabPadding)
                .size(AppDimens.FabSize)



                
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_add_24),
                contentDescription = null
            )

        }
    }
}
