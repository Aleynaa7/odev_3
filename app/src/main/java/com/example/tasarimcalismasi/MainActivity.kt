package com.example.tasarimcalismasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tasarimcalismasi.ui.theme.AnaRenk
import com.example.tasarimcalismasi.ui.theme.TasarimCalismasiTheme
import com.example.tasarimcalismasi.ui.theme.YaziRenk1
import com.example.tasarimcalismasi.ui.theme.YaziRenk2
import com.example.tasarimcalismasi.ui.theme.pacifico
import androidx.compose.ui.unit.dp
import com.example.tasarimcalismasi.ui.theme.AnaRenkDark
import com.example.tasarimcalismasi.ui.theme.AppBarRenk
import com.example.tasarimcalismasi.ui.theme.UrunIsimRenk
import com.example.tasarimcalismasi.ui.theme.UrunIsimRenkDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TasarimCalismasiTheme {
                Anasayfa()
            }
        }
    }
}


//res klasörü resource kaynak demekyir buralardaki klasörlere bir şeyler eklemek isteyebiliriz, klasöz ya da dosya isimleri küçük harfle olamk zorunda ve boşluk yok

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//dark tema ise true değilse false bilgiisni almak için burayı ekledik, şimdi color.kt'deki dark theme renklerni eklediğimiz yerlerde dark tema olunca otomatik o renkleri çekecektir

fun Anasayfa(darkTheme: Boolean = isSystemInDarkTheme()) {
    val configuration = LocalConfiguration.current
    val ekranYuksekligi = configuration.screenHeightDp
    val ekranGenisligi = configuration.screenWidthDp

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.candleBaslik), fontFamily = pacifico) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (darkTheme) AnaRenkDark else AppBarRenk,
                    titleContentColor = YaziRenk1
                ),
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.basket2),
                            contentDescription = "Sepet",
                            tint = YaziRenk1
                        )
                    }
                }
            )
        },
        bottomBar = {
            // Burada bir BottomBar ekliyoruz ve içine Text yerleştiriyoruz
            BottomAppBar(
                containerColor = if (darkTheme) AnaRenkDark else AppBarRenk,
                contentColor = YaziRenk1,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(text = stringResource(id = R.string.bottombarMetin),
                        fontSize = (ekranGenisligi / 17).sp)
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.candleİsim),
                color = if (darkTheme) UrunIsimRenkDark else UrunIsimRenk,
                fontWeight = FontWeight.Bold,
                fontSize = (ekranGenisligi / 10).sp
            )
            Image(painter = painterResource(id = R.drawable.jasmine), contentDescription = "")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(6) { index ->
                    Image(
                        painter = if (index == 0) {
                            painterResource(id = R.drawable.filled_circle)
                        } else {
                            painterResource(id = R.drawable.circle)
                        },
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(14.dp)
                            .clip(CircleShape)
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.urunBaslik),
                color = if (darkTheme) UrunIsimRenkDark else AnaRenk,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = stringResource(id = R.string.urunAciklama),
                color = if (darkTheme) UrunIsimRenkDark else YaziRenk2,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Row (modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(id = R.string.fiyatYazi), color = if (darkTheme) UrunIsimRenkDark else AnaRenk, fontWeight = FontWeight.Bold, fontSize = 35.sp)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Eksi Butonu
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.remove), // Eksi ikonu
                            contentDescription = "Azalt",
                            modifier = Modifier.size(24.dp),
                            tint = if (darkTheme) UrunIsimRenkDark else AnaRenk
                        )
                    }

                    // Sayı
                    Text(
                        text = "1",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = if (darkTheme) UrunIsimRenkDark else AnaRenk
                    )

                    // Artı Butonu
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.add), // Artı ikonu
                            contentDescription = "Artır",
                            modifier = Modifier.size(24.dp),
                            tint = if (darkTheme) UrunIsimRenkDark else AnaRenk
                        )
                    }
                }
            }


        }
    }
}


@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    TasarimCalismasiTheme {
        Anasayfa()
    }
}


