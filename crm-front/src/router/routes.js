import Layout from "@/layout";

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        children: [
            {
                path: '/',
                component: () => import('../views/WelcomeView')
            },
            {
                path: '/customer/manager',
                component: () => import('../views/CustomManageView')
            },
            {
                path: '/customer/drains',
                component: () => import('../views/CustomDrainsView')
            },
            {
                path: '/market/chance',
                component: () => import('../views/CustomChanceVIew')
            },
            {
                path: '/market/develop',
                component: () => import('../views/CustomDevelopPlainView')
            },
            {
                path: '/report/info',
                component: () => import('../views/CustomerPieView')
            },
            {
                path: '/resource/manager',
                component: () => import('../views/ResourceView')
            },
            {
                path: '/role/manager',
                component: () => import('../views/RoleView')
            },
            {
                path: '/user/manager',
                component: () => import('../views/UserView')
            },
            {
                path: '/organization/manager',
                component: () => import('../views/OrganizationView')
            },
            {
                path: '/sysLog/manager',
                component: () => import('../views/LoginLogView')
            },
            {
                path: '/sysLog/address',
                component: () => import('../views/CustomManageView')
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('../views/LoginView')
    }
]

export default routes;
