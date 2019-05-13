package dev.epool.presentation

import dev.epool.model.Member

interface MembersView : BaseView {

    var isUpdating: Boolean

    fun onUpdate(members: List<Member>)

}