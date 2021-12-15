<template>
    <div class="container-fluid background py-5">
        <div class="container my-5">
            <div class="row">
                <div class="col-6 offset-3">
                    <div class="bg-white rounded-3 p-5">
                        <h3>
                            <span class="fw-bold text-emerald">Rester Rent</span>
                            <span class="fw-lighter text-secondary"> | Management</span>
                        </h3>
                        <div class="mt-4">
                            <div v-if="loading" class="text-center p-5">
                                <div class="spinner-border text-secondary" role="status">
                                    <span class="visually-hidden">Loading ...</span>
                                </div>
                                <div class="mt-4 fw-light text-secondary">อยู่ระหว่างดำเนินการ</div>
                            </div>
                            <button v-else @click="openGoogleSignIn" class="btn btn-outline-primary w-100 px-4 py-3">
                                <i class="fab fa-google"></i>
                                Sign-in with Google
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
.background {
    background-color: var(--emerald);
    min-height: 100vh;
}
.spinner-border {
    width: 5em;
    height: 5em;
}
</style>
<script>
import { getAuth, GoogleAuthProvider, signInWithPopup } from 'firebase/auth'

export default {
    data() {
        return {
            user: {
                name: null,
                email: null,
                googleId: null,
                accessToken: null
            },
            loading: false
        }
    },
    methods: {
        async openGoogleSignIn() {

            // Enable loading to hide the button
            this.loading = true

            const provider = new GoogleAuthProvider()
            provider.setCustomParameters({
                login_hint: 'user@it.kmitl.ac.th'
            })

            const auth = getAuth()
            auth.languageCode = 'it'

            try {

                // Open Google Sign-in Popup window and wait for user data
                const result = await signInWithPopup(auth, provider)
                const credential = GoogleAuthProvider.credentialFromResult(result)
                const token = credential.accessToken
                const user = result.user

                let payload = {
                    name: user.displayName,
                    email: user.email,
                    googleId: user.providerData[0].uid,
                    accessToken: token
                }

                this.user = payload

            } catch (error) {
                const errorCode = error.code
                const errorMessage = error.message
                const email = error.email
                const credential = GoogleAuthProvider.credentialFromError(error)
            }
        }
    }
}
</script>