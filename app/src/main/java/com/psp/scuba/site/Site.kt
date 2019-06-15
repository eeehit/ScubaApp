package com.psp.scuba.site

import java.io.Serializable

class Site(
    var id: Int = 0,
    var name: String = "",
    var summary: String = "",
    var photo: String = "",
    var instagram_url: String = ""
) : Serializable
