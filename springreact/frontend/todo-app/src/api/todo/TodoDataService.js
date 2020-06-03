import axios from 'axios'

class TodoDataService{
    retrieveAllTodos(name){
        console.log('Executed ListTodos Service')
        return axios.get(`http://10.76.110.207:6262/users/${name}/todos`)

        
    }

    retrieveTodo(name,id){
        console.log('Executed ListTodo Service')
        return axios.get(`http://10.76.110.207:6262/users/${name}/todos/${id}`)

        
    }
    deleteTodo(name,id){
        console.log('Executed DeleteTodo Service')
        return axios.delete(`http://10.76.110.207:6262/users/${name}/todos/${id}`)

        
    }


}

export default new TodoDataService()