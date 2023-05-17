package com.fahad.samples.compose_template_ii.data.auth

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun provideAuthDataSource(authService: AuthService) = AuthDataSource(authService)

    @Singleton
    @Provides
    fun provideAuthRepository(
        authDataSource: AuthDataSource,
    ) = AuthRepository(authDataSource)
}