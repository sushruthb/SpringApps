import axios from 'axios'

class TodoDataService{
    retrieveAllTodos(name){
        console.log('Executed ListTodos Service')
        return axios.get(`http://10.76.110.207:6262/users/${name}/todos`);

        
    }

    retrieveTodo(name,id){
        console.log('Executed ListTodo Service')
        return axios.get(`http://10.76.110.207:6262/users/${name}/todos/${id}`);

        
    }
    deleteTodo(name,id){
        console.log('Executed DeleteTodo Service')
        return axios.delete(`http://10.76.110.207:6262/users/${name}/todos/${id}`);

        
    }
    updateTodo(name,id,todo){
        console.log('Executed UpdateTodo Service')
        return axios.put(`http://10.76.110.207:6262/users/${name}/todos/${id}`, todo);

        
    }
    createTodo(name,todo){
        console.log('Executed UpdateTodo Service')
        return axios.post(`http://10.76.110.207:6262/users/${name}/todos/`, todo);

        
    }


}

export default new TodoDataService()