package com.scarafia.mediamonks.application.di

import com.scarafia.mediamonks.application.networking.RetrofitApi
import com.scarafia.mediamonks.application.networking.services.TypicodeService
import com.scarafia.mediamonks.application.repository.TypicodeRepository
import com.scarafia.mediamonks.application.repository.TypicodeRepositoryImpl
import com.scarafia.mediamonks.presentation.screens.homescreen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModelsModule = module {
    viewModel { HomeViewModel(get()) }
}

val repositoryModule = module {
    single<TypicodeRepository> { TypicodeRepositoryImpl(get()) }
}

val serviceModule = module {
    single { get<Retrofit>().create(TypicodeService::class.java) }
}

val apiModule = module {
    single { RetrofitApi().getRetrofit() }
}

val modulesList = listOf(
    apiModule,
    serviceModule,
    repositoryModule,
    viewModelsModule
)