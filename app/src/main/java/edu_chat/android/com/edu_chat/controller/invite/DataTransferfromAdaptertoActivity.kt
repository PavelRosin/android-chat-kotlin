package edu_chat.android.com.edu_chat.controller.invite

import edu_chat.android.com.edu_chat.model.SearchUser
import java.util.*

internal interface DataTransferfromAdaptertoActivity {
	fun idList(userIds: ArrayList<SearchUser>)
}
