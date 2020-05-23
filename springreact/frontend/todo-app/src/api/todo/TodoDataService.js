import axios from 'axios'

class TodoDataService{
    retrieveAllTodos(name){
        console.log('Executed ListTodos Service')
        return axios.get(`http://10.76.110.207:6262/users/${name}/todos`)

        
    }


}

export default new TodoDataService()