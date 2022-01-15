const productResolver = {
    Query: {
        getProductoById: async (_, { codProducto }, { dataSources }) => {
            return await dataSources.productAPI.getProduct(codProducto)
        },
        allProducts: async (_, { }, { dataSources }) => {
            return await dataSources.productAPI.getAllProducts();
        },
    },
    Mutation: {
        crearProducto: async (_, { userInput }, { dataSources }) => {
            const productInput = {
                codProducto: userInput.codProducto,
                nombreProducto: userInput.nombreProducto,
                descripcionProducto: userInput.descripcionProducto,
                precioProducto: userInput.precioProducto
            }
            
            return await dataSources.productAPI.createProduct(productInput);
        },
        actualizarProducto: async (_, { userInput }, { dataSources }) => {
            const codProductoInput = userInput.codProducto
            const productInput = {
                codProducto: userInput.codProducto,
                nombreProducto: userInput.nombreProducto,
                descripcionProducto: userInput.descripcionProducto,
                precioProducto: userInput.precioProducto
            }
            return await dataSources.productAPI.updateProduct(codProductoInput, productInput );
        },
    }
};
module.exports = productResolver;