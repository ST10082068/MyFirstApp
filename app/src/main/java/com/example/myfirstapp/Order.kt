package com.example.myfirstapp

class Order() {

    lateinit var productName: String
    lateinit var customerName: String
    lateinit var customerCell: String
    lateinit var orderDate: String

    constructor(pName:String): this(){
        productName = pName
    }

    constructor(pName: String, cName: String, cEll: String, oDate: String): this(pName){
        customerName = cName
        customerCell = cEll
        orderDate = oDate
    }

}