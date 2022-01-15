const { gql } = require('apollo-server');

const authTypeDefs = gql`
    type Tokens {
        refresh: String!
        access: String!
    }
    type Access {
        access: String!
    }
    input CredentialsInput {
        username: String!
        password: String!
    }
    input SignUpInput {
        username: String!
        password: String!
        name: String!
        email: String!
    }
    type UserDetail {
        username: String
        name: String
        email: String
        contract_date: String
        
    }
    type Mutation {
        signUpUser(userInput :SignUpInput): Tokens!
        logIn(credentials: CredentialsInput!): Tokens!
        refreshToken(refresh: String!): Access!
    }
    type Query {
        userDetailById(userId: Int!): UserDetail!
        getByUserName(username: String!): [UserDetail]
        allPersons: [UserDetail]!
    }
`;
module.exports = authTypeDefs;