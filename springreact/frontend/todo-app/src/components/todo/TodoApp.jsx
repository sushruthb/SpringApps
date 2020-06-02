import React, { Component } from "react"
import {BrowserRouter as Router,Switch, Route } from "react-router-dom"

import AuthenticatedRoute from './AuthenticatedRoute.jsx'
import LoginComponent from './LoginComponent.jsx'
import LogoutComponent from './LogoutComponent.jsx'
import ListToDosComponent from './ListTodosComponent'
import HeaderComponent from './HeaderComponent'
import FooterComponent from './FooterComponent'
import WelcomeComponent from './WelcomeComponent'
import ErrorComponent from './ErrorComponent'
import TodoComponent from './TodoComponent.jsx'

class TodoApp extends Component{

    render(){

        return(

            <div className='todoapp'>
                <Router>
                    <HeaderComponent />
                    <Switch>
                    <Route path="/" exact component={LoginComponent} />
                    <Route path="/login" component={LoginComponent} />
                    <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent} />
                    <AuthenticatedRoute path="/todos/:id" component={TodoComponent} />
                    <AuthenticatedRoute path="/todos" component={ListToDosComponent} />
                    <AuthenticatedRoute path="/logout" component={LogoutComponent} />
                   
                    <Route component={ErrorComponent} />
                    </Switch>
                    <FooterComponent />
                </Router>
              
            
            </div>
        )
    }
    
}




export default TodoApp