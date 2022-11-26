package com.arghamnegargroup.core.features.customer.domain.usecase

data class CustomerUseCase(
    val getCustomer: GetCustomer,
    val saveCustomer: SaveCustomer,
    val getCredit: GetCredit,
    val useCredit: UseCredit,
    val useRemainCredit: UseRemainCredit,
)
