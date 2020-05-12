import React from 'react';

export class FirstComponent extends React.Component {
    render() {
        return <div>First component: <input type='text' name='uname' ref='uname' onChange={this.textChangeAction.bind(this)}></input></div>
    }

    textChangeAction() {
        this.props.copyTextFunc(this.refs.uname.value);
    }
}
