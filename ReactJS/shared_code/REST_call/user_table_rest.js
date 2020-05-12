import React from 'react';

export class UserComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {users: []};

        // read all entities
        fetch("http://localhost:8080/myapp/user", {
        "method": "GET",
        "headers": {
            "Access-Control-Allow-Origin": "*"
        }
        })
        .then(response => response.json())
        .then(response => {
            console.log('REST Response : ', response);
            this.setState({users: response});
        })
        .catch(err => { console.log(err); 
        });
    }
    render() {
        return <h1>Users:   {this.state.users.map(user => (
            user.userName + '  '
          ))}</h1> //JSX (JavaScript XML) code
    }
}
