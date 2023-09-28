package com.example.farmtech.models

class Product{
    var name:String=""
    var price:String=""
    var quantity:String=""
    var description:String=""
    var id: String=""

    constructor(name: String, price: String, quantity: String, description: String, id: String) {
        this.name = name
        this.price = price
        this.quantity = quantity
        this.description = description
        this.id = id
    }

}
