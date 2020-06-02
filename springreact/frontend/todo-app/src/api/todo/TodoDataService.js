import axios from 'axios'

class TodoDataService{
    retrieveAllTodos(name){
        console.log('Executed ListTodos Service')
        return axios.get(`http://10.76.110.207:6262/users/${name}/todos`)

        
    }

    deleteTodo(name,id){
        console.log('Executed DeleteTodo Service')
        return axios.delete(`http://10.76.110.207:6262/users/${name}/todos/${id}`,
        
        {
            headers:{
                'Access-Control-Allow-Origin':'*',
                'Content-Type': 'application/json;charset=UTF-8',
            }
        }
        )

        
    }


}

export default new TodoDataService()