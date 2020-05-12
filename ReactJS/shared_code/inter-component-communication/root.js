import React from 'react';
import { FirstComponent } from './first.js';
import { SecondComponent } from './second.js';

export class RootComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {messageText: ''};
    }
    render() {
        return <div><center><br/><br/><br/><FirstComponent copyTextFunc={this.copyTextToDuplicateTextBox.bind(this)}/><br/><br/><br/>
        <SecondComponent message={this.state.messageText}/></center></div>
    }

    copyTextToDuplicateTextBox(text) {
        this.setState({messageText: text});
    }
}
