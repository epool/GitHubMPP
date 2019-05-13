package dev.epool

import dev.epool.api.GithubApi
import dev.epool.model.Member
import dev.epool.model.MembersDataRepository
import dev.epool.presentation.MembersPresenter
import dev.epool.presentation.MembersView
import react.*
import react.dom.div
import react.dom.h2

interface AppState : RState {
    var members: List<Member>
    var greeting: String
}

private class App : RComponent<RProps, AppState>(), MembersView {

    private val repository = MembersDataRepository(GithubApi())
    private val presenter = MembersPresenter(this, repository)

    override var isUpdating: Boolean = false

    override fun onUpdate(members: List<Member>) {
        setState { this.members = members }
    }

    override fun showError(error: Throwable) {
        console.error(error)
    }

    override fun componentWillMount() {
        presenter.onCreate()
        setState { greeting = Greeting().greeting() }
    }

    override fun RBuilder.render() {
        div("mdc-layout-grid") {
            div("mdc-layout-grid__inner") {
                div("mdc-layout-grid__cell mdc-layout-grid__cell") {
                    h2 {
                        +state.greeting
                    }
                    membersList(state.members) {
                        setState { greeting = it.login }
                    }
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {
}