export class User {
        public userName: string;
        public password: string;
        public firstName: string;
        public lastName: string;
        public phone: string;

        constructor(
                userName: string,
                password: string,
                firstName: string,
                lastName: string,
                phone: string,

        ) {
                this.userName = userName
                this.password=password
                this.firstName=firstName
                this.lastName=lastName
                this.phone=phone
            }
}
