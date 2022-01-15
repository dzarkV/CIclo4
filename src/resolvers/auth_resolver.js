const usersResolver = {
    Query: {
        userDetailById: (_, { userId }, { dataSources, userIdToken }) => {
            if (userId == userIdToken)
                return dataSources.authAPI.getUser(userId)
            else
                return null
        },
        allPersons: async (_, {  }, { dataSources }) => {
            return await dataSources.authAPI.getAllUser();
        },
        getByUserName: async (_, {username}, {dataSources})=> {
            return await dataSources.authAPI.getUserByUserName(username);
        },
    },
    Mutation: {
        signUpUser: async (_, { userInput }, { dataSources }) => {
            // const accountInput = {
            //     username: userInput.username,
            //     balance: userInput.balance,
            //     lastChange: (new Date()).toISOString()
            // }
            // await dataSources.accountAPI.createAccount(accountInput);
            const authInput = {
                username: userInput.username,
                password: userInput.password,
                name: userInput.name,
                email: userInput.email,
            }
            return await dataSources.authAPI.createUser(authInput);
        },
        logIn: (_, { credentials }, { dataSources }) =>
            dataSources.authAPI.authRequest(credentials),
        refreshToken: (_, { refresh }, { dataSources }) =>
            dataSources.authAPI.refreshToken(refresh),
    }
};
module.exports = usersResolver;