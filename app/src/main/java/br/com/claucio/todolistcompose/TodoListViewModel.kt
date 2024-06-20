package br.com.claucio.todolistcompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoListViewModel: ViewModel() {

    //Criando os estados
    private val _textState = MutableStateFlow("")
    val textState = _textState.asStateFlow()


    private val _items = MutableStateFlow<List<ItemList>>(emptyList())
    val items = _items.asStateFlow()


    //Função usada para passar o valor do TextField para o estado _textState
    fun onTextChanged(text: String) {
        _textState.value = text
    }


    //Função usada para adicionar um item na lista
    fun addItem() {
        val item = _textState.value
        if (item.isNotBlank()) {
            _items.value += ItemList(item)
            _textState.value = ""//Limpando o TextField após adicionar um item na lista
        }
    }
}