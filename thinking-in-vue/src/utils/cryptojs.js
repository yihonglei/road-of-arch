import CryptoJS from 'crypto-js'


// 此处的密钥随机生成，可自行修改
const key = CryptoJS.enc.Utf8.parse('C327F511796BA870');// 十六位十六进制数作为密钥
const iv = CryptoJS.enc.Utf8.parse('093C314DAE3A8792');// 十六位十六进制数作为密钥偏移量


// 解密方法
export const myDecrypt = function (word) {
    let decrypt = CryptoJS.AES.decrypt(word, key, { iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7 });
    let decryptedStr = decrypt.toString(CryptoJS.enc.Utf8);
    return decryptedStr.toString();
}

// 加密方法
export const myEncrypt = function (word) {
    let srcs = CryptoJS.enc.Utf8.parse(word);
    let encrypted = CryptoJS.AES.encrypt(srcs, key, { iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7 });
    return encrypted.toString();
}
