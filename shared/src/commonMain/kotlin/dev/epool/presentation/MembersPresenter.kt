package dev.epool.presentation

import dev.epool.applicationDispatcher
import kotlinx.coroutines.launch

class MembersPresenter(
    private val view: MembersView,
    private val repository: DataRepository
) : CoroutinePresenter(applicationDispatcher, view) {

    private val onRefreshDataListener = this::showData

    override fun onCreate() {
        view.isUpdating = isFirstDataLoading()
        repository.onRefreshListeners += onRefreshDataListener
        showData()
        updateData()
    }

    override fun onDestroy() {
        super.onDestroy()
        repository.onRefreshListeners -= onRefreshDataListener
    }

    private fun showData() {
        view.onUpdate(repository.members.orEmpty())
    }

    private fun updateData() {
        launch {
            repository.update()
            showData()
        }.invokeOnCompletion {
            view.isUpdating = false
        }
    }

    private fun isFirstDataLoading() = repository.members == null

}