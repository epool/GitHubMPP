package dev.epool

import dev.epool.model.Member
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

interface MembersListProps : RProps {
    var members: List<Member>
    var onClickListener: (Member) -> Unit
}

class MembersListComponent : RComponent<MembersListProps, RState>() {
    override fun RBuilder.render() {
        ul("mdc-image-list my-image-list") {
            props.members.forEach { item ->
                li("mdc-image-list__item") {
                    div("mdc-image-list__image-aspect-container") {
                        img(src = item.avatarUrl, classes = "mdc-image-list__image") { }
                    }
                    div("mdc-image-list__supporting") {
                        span("mdc-image-list__label") {
                            +item.login
                        }
                    }
                    attrs {
                        onClickFunction = { props.onClickListener(item) }
                    }
                }
            }
        }
    }
}

fun RBuilder.membersList(data: List<Member>, block: (Member) -> Unit) =
    child(MembersListComponent::class) {
        attrs.members = data
        attrs.onClickListener = block
    }