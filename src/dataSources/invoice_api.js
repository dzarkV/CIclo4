const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');

class InvoiceAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.invoice_api_url;
    }
    async createInvoice(invoice) {
        invoice = new Object(JSON.parse(JSON.stringify(invoice)));
        console.log(invoice);
        return await this.post(`/facturas/crear`, invoice);
    }
    async updateInvoice(idFactura, invoice){
        invoice = new Object(JSON.parse(JSON.stringify(invoice)));
        return await this.patch(`/facturas/editar/${idFactura}`, invoice);
    }
    async getInvoice(idFactura) {
        return await this.get(`/facturas/${idFactura}`);
    }
    async getAllInvoices() {
        return await this.get(`/facturas/all`);
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
module.exports = InvoiceAPI;