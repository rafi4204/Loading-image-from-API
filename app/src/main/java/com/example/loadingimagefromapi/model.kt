package com.example.loadingimagefromapi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class model {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: Url? = null
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null

}

class Url {

    @SerializedName("small")
    @Expose
    var small: String? = null
    @SerializedName("medium")
    @Expose
    var medium: String? = null
    @SerializedName("large")
    @Expose
    var large: String? = null

}