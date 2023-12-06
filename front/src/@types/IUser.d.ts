export default interface IUser {
    id?: number;
    name?: string;
    email?: string;
    password?: string;
    passwordConfirm?: string;
    created_at?: Date;
    updated_at?: Date;
    isLogin?: boolean;
}
