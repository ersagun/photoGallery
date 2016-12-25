import React, { Component } from 'react';
//import logo from './logo.svg';
//import axios from 'axios'
import $ from 'jquery'
import './App.css';


class App extends Component {
		
	 constructor(props) {
		    super(props);
		    this.state = {photos: []};
		  }

		  componentDidMount() {
			    var th = this;
			    this.serverRequest = 
			     // axios.get(this.props.source).then(function(result) { th.setState({photos: result.data.photos});});
			    
			    $.ajax({
			        url: this.props.source,
			        dataType: 'json',
			        cache: false,
			        headers: {
	                    'Access-Control-Allow-Origin': '*'
	                },
			        success: function(result) {
			          th.setState({photos: result.data.photos}); // Notice this
			        }.bind(this),
			        error: function(xhr, status, err) {
			          console.error(this.props.source, status, err.toString());
			        }.bind(this)
			      });
		  
		  
		  
		  
		  }

		  componentWillUnmount() {
			  this.serverRequest.abort();
		  }

		  render() {
			    return (
			    		<div>
			        <h1>photos!</h1>
			        {this.state.photos.map(function(photo) {
			          return (
			            <div key={photo.pseudo} className="job">
			              <a href={photo.pseudo}>
			                {photo.longitude}
			                --------------- 
			                {photo.latitude}
			                {photo.image}
			              </a>
			            </div>
			          );
			        })}
			      </div>
			    );
			  }
	
}
	
/**
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }**/
//} 


/**
var App = React.createClass({
	  
	  getInitialState: function() {
	    return {
	      photos: []
	    }
	  },
	  
	  componentDidMount: function() {
	    // Is there a React-y way to avoid rebinding `this`? fat arrow?
	    var th = this;
	    this.serverRequest = 
	      axios.get(this.props.source)
	        .then(function(result) {    
	          th.setState({
	            photos: result.data.photos
	          });
	        })
	  },
	  
	  componentWillUnmount: function() {
	    this.serverRequest.abort();
	  },
	  
	  render: function() {
	    return (
	      <div>
	        <h1>photos!</h1>
	        {this.state.photos.map(function(job) {
	          return (
	            <div key={job.pseudo} className="job">
	              <a href={job.pseudo}>
	                {job.longitude}
	                is looking for a 
	                {job.latitude}
	                {job.image}
	              </a>
	            </div>
	          );
	        })}
	      </div>
	    )
	  }
	});
**/
export default App;
