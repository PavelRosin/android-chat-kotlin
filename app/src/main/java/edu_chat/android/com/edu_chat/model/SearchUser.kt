package edu_chat.android.com.edu_chat.model

/**
 * Created by abmuthu on 8/2/16.
 * Edu.Chat Inc.
 */

class SearchUser {
	var firstName: String? = null
		private set
	var lastName: String? = null
		private set
	var email: String? = null
		private set
	private var id: Int = 0
		private set

	override fun hashCode(): Int = this.id

	override fun equals(other: Any?): Boolean = (other as SearchUser?)!!.id == this.id
}


