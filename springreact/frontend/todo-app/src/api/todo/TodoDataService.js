import axios from 'axios'
import {JPA_API_URL} from '../../Constants.js'
class TodoDataService{

    retrieveAllTodos(name){
        console.log('Executed ListTodos Service')
        return axios.get(`${JPA_API_URL}/users/${name}/todos`);
    }

    retrieveTodo(name,id){
        console.log('Executed ListTodo Service')
        return axios.get(`${JPA_API_URL}/users/${name}/todos/${id}`);
    }
    deleteTodo(name,id){
        console.log('Executed DeleteTodo Service')
        return axios.delete(`${JPA_API_URL}/users/${name}/todos/${id}`);
    }
    updateTodo(name,id,todo){
        console.log('Executed UpdateTodo Service')
        return axios.put(`${JPA_API_URL}/users/${name}/todos/${id}`, todo);
    }
    createTodo(name,todo){
        console.log('Executed CreateTodo Service')
        return axios.post(`${JPA_API_URL}/users/${name}/todos/`, todo);
    }
}

export default new TodoDataService()