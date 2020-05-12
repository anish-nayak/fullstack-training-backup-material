import React from 'react';

export class SecondComponent extends React.Component {
    
    render() {
        return <div>Second component: <input type='text' ref='duplicate_uname' name='duplicate_uname' value={this.props.message}></input></div>
    }
}
