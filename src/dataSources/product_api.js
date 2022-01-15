const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');
class ProductAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.invoice_api_url;
    }
    async createProduct(product) {
        product = new Object(JSON.parse(JSON.stringify(product)));
        return await this.post(`/productos/crear`, product);
    }
    async updateProduct(codProducto, product){
        product = new Object(JSON.parse(JSON.stringify(product)));
        return await this.patch(`/productos/editar/${codProducto}`, product);
    }
    async getProduct(codProducto) {
        return await this.get(`/productos/${codProducto}`);
    }
    async getAllProducts() {
        return await this.get(`/productos/all`);
    }
    // async authRequest(credentials) {
    //     credentials = new Object(JSON.parse(JSON.stringify(credentials)));
    //     return await this.post(`/login/`, credentials);
    // }
    // async refreshToken(token) {
    //     token = new Object(JSON.parse(JSON.stringify({ refresh: token })));
    //     return await this.post(`/refresh/`, token);
    // }
}
module.exports = ProductAPI;