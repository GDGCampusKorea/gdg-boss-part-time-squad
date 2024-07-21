package com.gdg.boss.partTimeJobPosting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.boss.base.BaseScreen

@Composable
fun PartTimeJobPostingScreen(
    viewModel: PartTimeJobPostingViewModel = hiltViewModel()
) {

    val handleEffect: (PartTimeJobPostingContract.PartTimeJobPostingSideEffect) -> Unit =
        { effect ->
            when (effect) {
                else -> {

                }
            }
        }

    BaseScreen(viewModel = viewModel, handleEffect = handleEffect) { uiState ->
        ScaffoldGdgBoss(uiState = uiState, onIntent = viewModel::handleIntent)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldGdgBoss(
    uiState: PartTimeJobPostingContract.PartTimeJobPostingUIState,
    onIntent: (PartTimeJobPostingContract.PartTimeJobPostingIntent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "알바 작성",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1D1B20),
                        lineHeight = 28.sp,  // 22sp + 6sp line spacing
                        fontFamily = FontFamily.SansSerif
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /* TODO: 뒤로 가기 버튼을 누르면 알바 목록 화면으로 이동 */ }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기 아이콘"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RectangleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E1E1),
                        shape = RectangleShape
                    ),
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFD1D1D1),
                        shape = RectangleShape
                    ),
                contentAlignment = Alignment.Center

            ) {
                Button(
                    onClick = { onIntent(PartTimeJobPostingContract.PartTimeJobPostingIntent.PartTimeJobPosting) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 48.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF998E8D)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "작성완료",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        letterSpacing = 0.01.em,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.SansSerif,
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                JobContent(uiState = uiState, onIntent = onIntent)
            }
        }
    )
}

@Composable
fun JobContent(
    uiState: PartTimeJobPostingContract.PartTimeJobPostingUIState,
    onIntent: (PartTimeJobPostingContract.PartTimeJobPostingIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp)
    ) {
        JobInfoInput(
            title = "제목",
            value = uiState.title,
            onValueChange = { onIntent(PartTimeJobPostingContract.PartTimeJobPostingIntent.TitleChange(it)) },
            placeholder = "제목을 입력하세요"
        )

        Spacer(modifier = Modifier.height(12.dp))

        JobInfoInput(
            title = "내용",
            value = uiState.content,
            onValueChange = { onIntent(PartTimeJobPostingContract.PartTimeJobPostingIntent.ContentChange(it)) },
            placeholder = "내용을 입력하세요"
        )

        Spacer(modifier = Modifier.height(12.dp))

        JobInfoInput(
            title = "근무 시간",
            value = uiState.workTime,
            onValueChange = { onIntent(PartTimeJobPostingContract.PartTimeJobPostingIntent.WorkTimeChange(it)) },
            placeholder = "근무 시간을 입력하세요"
        )

        Spacer(modifier = Modifier.height(12.dp))

        JobInfoInput(
            title = "시급",
            value = uiState.hourlyWage,
            onValueChange = { onIntent(PartTimeJobPostingContract.PartTimeJobPostingIntent.HourlyWageChange(it)) },
            placeholder = "시급을 입력하세요"
        )

        Spacer(modifier = Modifier.height(12.dp))

        JobInfoInput(
            title = "위치",
            value = uiState.location,
            onValueChange = { onIntent(PartTimeJobPostingContract.PartTimeJobPostingIntent.LocationChange(it)) },
            placeholder = "위치를 입력하세요"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobInfoInput(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color(0xFF333333),
            lineHeight = 28.sp // 22sp text size + 6sp line spacing extra
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text(text = placeholder) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}