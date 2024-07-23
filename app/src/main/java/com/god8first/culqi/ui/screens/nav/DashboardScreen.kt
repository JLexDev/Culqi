package com.god8first.culqi.ui.screens.nav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.god8first.culqi.components.MyResourceItemComponent
import com.god8first.culqi.domain.viewmodel.DashboardViewModel
import com.god8first.culqi.util.extension.toast
import com.god8first.culqi.ui.components.StateObserver
import com.god8first.culqi.ui.theme.CulqiTheme

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getMyResourcesList()
    }
    val context = LocalContext.current

    StateObserver(
        state = viewModel.uiState,
        onIdle = { },
        onLoading = { },
        onSuccess = { myResource ->
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = Color.White
            ) {

                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Recursos",
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        items(myResource.data) { colorItem ->
                            MyResourceItemComponent(data = colorItem)
                        }
                    }
                }
            }
        },
        onError = { errorMessage ->
            context.toast("Error: $errorMessage")
        }
    )
}

@Preview
@Composable
fun DashboardScreenPreview() {
    CulqiTheme {
        DashboardScreen()
    }
}