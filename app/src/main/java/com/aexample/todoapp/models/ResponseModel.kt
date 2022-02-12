package com.aexample.todoapp.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("scheduledDate")
	val scheduledDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)
