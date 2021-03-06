import React, { Component } from "react"
import AuthenticationService from './AuthenticationService.js'
import TodoDataService from '../../api/todo/TodoDataService.js'
import moment from 'moment'

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
            ] ,
            message : null
        }

        this.deleteTodoClicked=this.deleteTodoClicked.bind(this)
        this.updateTodoClicked=this.updateTodoClicked.bind(this)
        this.refreshTodos=this.refreshTodos.bind(this)
        this.addTodoClicked=this.addTodoClicked.bind(this)
    }
    componentWillUnmount(){
        console.log('componentWillUnmount')
    }

    shouldComponentUpdate(){

        return true
    }


    componentDidMount(){
        console.log('Component didmount')
        this.refreshTodos();
        console.log(this.state)

    }

    refreshTodos(){

        let username=AuthenticationService.getUserLoggedInUserName()
        TodoDataService.retrieveAllTodos(username)
        .then(
            response => {
                console.log(response)
                this.setState({ todos: response.data })
            }
        )

    }

    deleteTodoClicked(id){
        let username=AuthenticationService.getUserLoggedInUserName()
        console.log(id + " " + username)
        TodoDataService.deleteTodo(username,id)
        .then(
            response => {
                this.setState({message : `Deleted of todo ${id} Successfull`});
                this.refreshTodos();
            }
        )


    }
    addTodoClicked(){
        console.log('Add ')
        this.props.history.push(`/todos/-1`)
    

    }
    updateTodoClicked(id){
        console.log('Update ' + id)
        this.props.history.push(`/todos/${id}`)
    

    }
    render(){
        console.log("render")
        return (
            <div> 
                <h1>List Todos</h1>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                <table className="table">
                    <thead>
                        <tr>
                            
                            <th>Description</th>
                            <th>TargetDate</th>
                            <th>IsCompleted</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.todos.map(
                            todo =>
                            <tr key={todo.id}>
                              <td>{todo.description}</td>
                              <td>{moment(todo.targetDate).format('YYYY-MM-DD')}</td>
                              <td>{todo.done.toString()}</td>
                              <td><button className='btn btn-success' onClick={ ()=> this.updateTodoClicked(todo.id) }>Update</button></td>
                              <td><button className='btn btn-warning' onClick={ ()=> this.deleteTodoClicked(todo.id) }>Delete</button></td>
                            </tr>
                        )

                    }
                        
                    </tbody>
                </table>
                <div className="row">
                       <button className="btn btn-success" onClick={this.addTodoClicked}>Add</button> 
                </div>
                </div>
            </div>
        )
    }

}

export default ListToDosComponent