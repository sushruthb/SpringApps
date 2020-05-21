
import React, { Component } from "react"
import {Link} from 'react-router-dom';

import HelloWorldService from '../../api/todo/HelloWorldService.js'

class WelcomeComponent extends Component{

    constructor(props){
        super(props)
        this.retrieveWelcomeMessage=this.retrieveWelcomeMessage.bind(this)
        this.state={
            welcomeMessage :' '
        }

        this.handleSucessfulResponse=this.handleSucessfulResponse.bind(this)
    }
    render(){
        return (
        <>
            <h1>Welcome!</h1>
            <div className="container">
               Welcome to ReactJS {this.props.match.params.name}. 
                You can manage your todos <Link to='/todos'>here</Link>
                
            </div>
            <div className="Container">
                Click here to get customized welcome message. 
                <button onClick={this.retrieveWelcomeMessage} className="btn btn-success">Get Welcome Message</button>
            </div>
            <div className="Container">
                {this.state.welcomeMessage}
            </div>
        </>
        )
    }

    retrieveWelcomeMessage(){
        HelloWorldService.executeHelloWorldService()
            .then(response => this.handleSucessfulResponse(response))
        //return Axios.get('http://10.76.110.207:6262/')
    }

    handleSucessfulResponse(response){
        this.setState({welcomeMessage: response.data })
        
    }
}

export default WelcomeComponent