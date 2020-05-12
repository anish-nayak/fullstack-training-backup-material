import React from 'react';
import {Link, BrowserRouter, Route, Switch} from 'react-router-dom';
import { Page1Component } from './page1';
import { createBrowserHistory as history} from 'history';

export class Page2Component extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return <div align="center" style={{['margin-top']:100, ['margin-left']:0}}>
            <BrowserRouter>
                <Switch>
                    <Route path="/" exact component={Page1Component}/>
                    <button><Link to="/">Page1</Link></button>
                </Switch>
            </BrowserRouter>
            </div>
        
    }
}