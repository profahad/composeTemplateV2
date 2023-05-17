package com.fahad.samples.compose_template_ii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.fahad.samples.compose_template_ii.ui.modules.auth.AuthActivity
import com.fahad.samples.compose_template_ii.ui.modules.dashboard.DashboardActivity
import com.fahad.samples.compose_template_ii.ui.theme.TemplateTheme
import com.fahad.samples.compose_template_ii.ui.theme.ApplyStatusBarColor
import com.fahad.samples.compose_template_ii.utils.session.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.firstOrNull

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {

    private val activityScope by lazy {
        CoroutineScope(Dispatchers.Main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                SplashView()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        initListeners()
    }

    private fun initListeners() {
        activityScope.launch {
            delay(1500)
            SessionManager.isLoginFlow.firstOrNull()?.let {
                when (it) {
                    true -> moveToDashboard()
                    false -> moveToLogin()
                }
            }
        }
    }

    private fun moveToDashboard() = DashboardActivity.createInstance(this).let {
        startActivity(it).apply {
            finishAffinity()
        }
    }

    private fun moveToLogin() = AuthActivity.createInstance(this).let {
        startActivity(it).apply {
            finishAffinity()
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}


@Composable
fun SplashView() {
    ApplyStatusBarColor()
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .aspectRatio(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashViewPreview() {
    TemplateTheme {
        SplashView()
    }
}