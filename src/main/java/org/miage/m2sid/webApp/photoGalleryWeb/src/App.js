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
			     // axios.get(this.props.source).then(function(result) { th.setState({photos: result});});
			    
			    $.ajax({
			        url: this.props.source,
			        dataType: 'json',
			        cache: false,
			      
			        success: function(result) {
			          th.setState({photos: result});
			        },
			        error: function(xhr, status, err) {
			          console.error(this.props.source, status, err.toString());
			        }
			      });
		  }
		  
		  componentWillUnmount() {
			  this.serverRequest.abort();
		  }
		  
		  render() {
			    return (
			    		<div className="row">
			    		
			        {this.state.photos.map(function(photo) {
			          return (
			        		  <div className="col-sm-6 col-md-4" key={photo.id}>
			        		    <div className="thumbnail">
			        		    <img id="image" src={photo.image} alt=""/>
			        		    <div className="caption">
			        		        <h3>{photo.pseudo}</h3>
			        		        <p>Longitude :  {photo.longitude} </p>
			        		        <p>Latitude :  {photo.latitude} </p>
			        		      </div>
			        		    </div>
			        		    </div>
			          );
			        })}
			      </div>
			    );
			  }	
}
export default App;
