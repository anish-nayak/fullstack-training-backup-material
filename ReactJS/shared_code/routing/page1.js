import React from 'react';
import {Link, BrowserRouter, Route, Switch} from 'react-router-dom';
import { Page2Component } from './page2';

export class Page1Component extends React.Component {
    render() {
        return <div align="center" style={{['margin-top']:100, ['margin-left']:0}} >
            <BrowserRouter>
                <Switch>
                    <Route path="/page2" exact component={Page2Component} />
                    <button><Link to="/page2">Page2</Link></button>
                </Switch>
            </BrowserRouter>
            </div>
    }
}

//<button name='page2' value='PAGE-2'></button>