import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';


/**
ReactDOM.render(
  <App />,
  document.getElementById('root')
); **/

ReactDOM.render(
		<App source="http://10.10.182.36:8080//api/photoGallery" />,
				document.getElementById('root')
				);
