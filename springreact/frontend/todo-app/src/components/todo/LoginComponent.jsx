import React, { Component } from "react"
import AuthenticationService from './AuthenticationService.js'


class LoginComponent extends Component{
    constructor(props){
        super(props)
        this.state={
            // username : 'sushruth',
            // password : '',
            hasLoginFailed : false,
            showSuccessMessage : false
        }
        this.handleChange=this.handleChange.bind(this)
        this.loginClicked=this.loginClicked.bind(this)
    }
    
handleChange(event){

    console.log(this.state);
    this.setState({[event.target.name]: event.target.value})

}

loginClicked(){
    console.log(this.state)
//     if(this.state.username==='sushruth' && this.state.password==='login'){
//         //console.log("Successful")
//         AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password)
//        this.props.history.push(`/welcome/${this.state.username}`)
//         //this.setState({showSuccessMessage: true})
//        // this.setState({hasLoginFailed: false})
//     }
//     else{
//         console.log("Failed")
//         this.setState({showSuccessMessage: false})
//         this.setState({hasLoginFailed: true})
//    }

    // AuthenticationService.executeBasicAuthenticationService(this.state.username,this.state.password)
    // .then(
    //     ()=>{
    //         AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password)
    //         this.props.history.push(`/welcome/${this.state.username}`)
    //     }

    //     ).catch( ()=>{
    //       this.setState({showSuccessMessage: false})
    //        this.setState({hasLoginFailed: true})

    //     })

     AuthenticationService.executeJWTAuthenticationService(this.state.username,this.state.password)
    .then(
        (response)=>{
            AuthenticationService.registerSuccessfulLoginForJwt(this.state.username,response.data.token)
            this.props.history.push(`/welcome/${this.state.username}`)
        }

        ).catch( ()=>{
          this.setState({showSuccessMessage: false})
           this.setState({hasLoginFailed: true})

        })
        
}
    render(){   
        return(
            <div>
            <h1>Login</h1>
            <div className="container">
            <div>
               {/*  <ShowInValidCredentials hasLoginFailed={this.state.hasLoginFailed} />*/}
                {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
            {/*    <ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage} />*/}
                {this.state.showSuccessMessage && <div>Login successful </div>}
                Username <input type='text' name='username' value={this.state.username} onChange={this.handleChange}/>
                Password <input type='password' name='password' value={this.state.password} onChange={this.handleChange} />
                <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
            </div>
            </div>
            </div>
        )
    }

   

}

// function ShowInValidCredentials(props){
    //    if(props.hasLoginFailed){
        //    return <div>Invalid Credentials</div>
    //    }
        //    return null
   // }

// function ShowLoginSuccessMessage(props){
    // if(props.showSuccessMessage){
        // return  <div>Login successful </div>
    // }
    // return null
// }

export default LoginComponent