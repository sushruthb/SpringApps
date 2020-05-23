import React, { Component } from "react"
import AuthenticationService from './AuthenticationService.js'
import TodoDataService from '../../api/todo/TodoDataService.js'


class ListToDosComponent extends Component{
   
    constructor(props){
        console.log('constructor')
        super(props)
        this.state ={
            todos :[

            //   {id: 1, description : 'Learn React', done: false, targetDate: new Date()} ,
            //    {id: 2, description : 'Learn Spring', done: false, targetDate: new Date()} ,
            //  {id: 3, description : 'Learn Full Stack Development', done: false, targetDate: new Date()} ,
            //    {id: 4, description : 'Learn Spring Microservices', done: false, targetDate: new Date()} 
            ] 
        }
    }
    componentWillUnmount(){

    }

    shouldComponentUpdate(){

        return true
    }
    componentDidMount(){
        console.log('Component digmount')
        let username=AuthenticationService.getUserLoggedInUserName
        TodoDataService.retrieveAllTodos(username)
        .then(
            response => {
                console.log(response)
                this.setState({todos: response.data})
            }
        )

    }
    render(){
        console.log("renter")
        return (
            <div> 
                <h1>List Todos</h1>
                <div className="container">
                <table className="table">
                    <thead>
                        <tr>
                            
                            <th>Description</th>
                            <th>IsCompleted</th>
                            <th>TargetDate</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.todos.map(
                            todo =>
                            <tr key={todo.id}>
                              <td>{todo.description}</td>
                              <td>{todo.done.toString()}</td>
                              <td>{todo.targetDate.toString()}</td>
                            </tr>
                        )

                    }
                        
                    </tbody>
                </table>
                </div>
            </div>
        )
    }

}

export default ListToDosComponent